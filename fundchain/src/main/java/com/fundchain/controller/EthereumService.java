package com.fundchain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import java.math.BigDecimal;

@Service
public class EthereumService {
    private final Web3j web3j;
    private final String masterAddress;
    private final String masterPrivateKey;

    public EthereumService(@Value("${ethereum.node.url}") String nodeUrl,
                          @Value("${ethereum.master.address}") String masterAddress,
                          @Value("${ethereum.master.privatekey}") String masterPrivateKey) {
        this.web3j = Web3j.build(new HttpService(nodeUrl));
        this.masterAddress = masterAddress;
        this.masterPrivateKey = masterPrivateKey;
    }

    public String sendTestEther(String toAddress, BigDecimal amount) throws Exception {
        return Transfer.sendFunds(web3j, masterPrivateKey, toAddress, amount, Convert.Unit.ETHER)
                .send().getTransactionHash();
    }

    public BigDecimal getBalance(String address) throws Exception {
        return Convert.fromWei(web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST)
                .send().getBalance().toString(), Convert.Unit.ETHER);
    }
}