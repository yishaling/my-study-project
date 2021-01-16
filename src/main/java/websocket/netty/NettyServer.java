package websocket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import websocket.netty.in.ChatHandler;
import websocket.netty.in.HeartBeatHandler;
//import websocket.netty.in.HeartBeatHandler;

/**
     * @author
     */
    public class NettyServer {
        public static void main(String[] args) {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            NioEventLoopGroup boos = new NioEventLoopGroup(1);
            NioEventLoopGroup worker = new NioEventLoopGroup(4);
            serverBootstrap
                    .group(boos, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        protected void initChannel(NioSocketChannel ch) {

                            ChannelPipeline pipeline = ch.pipeline();
                            ch.pipeline().addLast("HttpServerCodec",new HttpServerCodec());
                            ch.pipeline().addLast(new ChunkedWriteHandler());
                            //对写大数据流的支持
                            pipeline.addLast(new ChunkedWriteHandler());
                            //对httpMessage进行聚合，聚合成AggregatedFullHttpRequest和AggregatedFullHttpResponse
                            pipeline.addLast(new HttpObjectAggregator(1024 * 64));

                            // ====================== 增加心跳支持 start    ======================
                            // 针对客户端，如果在1分钟时没有向服务端发送读写心跳(ALL)，则主动断开
                            // 如果是读空闲或者写空闲，不处理
                            pipeline.addLast(new IdleStateHandler(8, 10, 12));
                            // 自定义的空闲状态检测
                            pipeline.addLast(new HeartBeatHandler());
                            // ====================== 增加心跳支持 end    ======================


                            //======================== websocket相关=============================

                            //websocket服务器处理的协议，用于指定给客户端连接访问的路由："/ws"
                            //本handler会帮你处理一些繁重的复杂的事。会帮你处理握手动作: handshaking
                            //对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同。
                            pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));


                            //自定义的handler
                            pipeline.addLast(new ChatHandler());
                        }
                    })
                    .bind(8080);
            System.err.println("【Netty Server 启动成功】");
        }
    }

