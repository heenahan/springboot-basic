package com.prgms.springbootbasic.voucher.model;

import java.io.IOException;
import java.util.List;

public interface VouchersStorage {

    void save(Voucher voucher) throws IOException;
    List<Voucher> findAll() throws IOException;

}