package com.ctrip.hermes.core.message.codec;

import io.netty.buffer.ByteBuf;

import com.ctrip.hermes.core.message.BaseConsumerMessage;
import com.ctrip.hermes.core.message.PartialDecodedMessage;
import com.ctrip.hermes.core.message.ProducerMessage;

public interface MessageCodec {

	public void encode(ProducerMessage<?> msg, ByteBuf buf);

	public byte[] encode(ProducerMessage<?> msg);

	public PartialDecodedMessage decodePartial(ByteBuf buf);

	public BaseConsumerMessage<?> decode(String topic, ByteBuf buf, Class<?> bodyClazz);

	void encode(PartialDecodedMessage msg, ByteBuf buf);
}
