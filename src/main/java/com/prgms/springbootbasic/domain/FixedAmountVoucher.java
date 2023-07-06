package com.prgms.springbootbasic.domain;

import com.prgms.springbootbasic.util.ExceptionMessage;
import com.prgms.springbootbasic.util.VoucherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class FixedAmountVoucher implements Voucher {
	
	private static final long MINIMUM = 0;
	private static final Logger logger = LoggerFactory.getLogger(FixedAmountVoucher.class);
	
	private final UUID voucherId;
	private final long amount;
	
	public FixedAmountVoucher(UUID voucherId, long amount) {
		throwWhenUnderMinimum(amount);
		this.voucherId = voucherId;
		this.amount = amount;
	}

	@Override
	public VoucherType getVoucherType() {
		return VoucherType.FIXED;
	}

	@Override
	public UUID getVoucherId() {
		return voucherId;
	}

	@Override
	public Long getNumber() { return amount; }

	private void throwWhenUnderMinimum(long amount) {
		if (amount <= MINIMUM) {
			logger.error("Fixed 바우처는 0과 음수를 가질 수 없습니다. amount : {}", amount);
			throw new IllegalArgumentException(ExceptionMessage.UNDER_MINIMUM_AMOUNT.getMessage());
		}
	}
	
}