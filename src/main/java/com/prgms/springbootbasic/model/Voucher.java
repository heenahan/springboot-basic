package com.prgms.springbootbasic.model;

import java.util.UUID;

public interface Voucher {
	
	UUID getVoucherId();
	long discount(long beforeAmount);
	String formatOfCSV();
	
}
