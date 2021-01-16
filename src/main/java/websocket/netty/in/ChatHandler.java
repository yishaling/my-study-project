package websocket.netty.in;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        HeartBeatHandler.users.writeAndFlush(new TextWebSocketFrame(
                JSONObject.toJSONString(msg.text())));
        System.out.println("好了，我收到了"+msg.text());
        // TextWebSocketFrame 是一个协议 解决了拆包黏包
//        ctx.writeAndFlush( );
    }

}
