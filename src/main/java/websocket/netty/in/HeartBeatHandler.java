package websocket.netty.in;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;
import websocket.netty.entity.DataContent;

public class HeartBeatHandler  extends ChannelInboundHandlerAdapter {
    //获取到所有的客户端channel。
    public static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        users.add(ctx.channel());
        // 判断evt是否是IdleStateEvent（用于触发用户事件，包含 读空闲/写空闲/读写空闲 ）
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent)evt;     // 强制类型转换

//            if (event.state() == IdleState.READER_IDLE) {
//                System.out.println("进入读空闲...");
//            } else if (event.state() == IdleState.WRITER_IDLE) {
//                System.out.println("进入写空闲...");
//            } else if (event.state() == IdleState.ALL_IDLE) {
//
//
//                Channel channel = ctx.channel();
//                // 关闭无用的channel，以防资源浪费
//                channel.close();
//
//            }
        }

    }

    /**
     * 当客户端连接服务端之后（打开连接）
     * 获取客户端的channel，并且放到ChannelGroup中去进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        users.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //当触发handler销毁时，这个会自动的移除的。
        users.remove(ctx.channel());

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //发生异常之后关闭连接，随后从ChannelGroup中移除
        ctx.channel().close();
        users.remove(ctx.channel());
    }
}
