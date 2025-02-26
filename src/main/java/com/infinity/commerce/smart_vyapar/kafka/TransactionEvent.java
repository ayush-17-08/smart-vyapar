package com.infinity.commerce.smart_vyapar.kafka;

import com.infinity.commerce.smart_vyapar.enums.TransactionStatus;
import com.infinity.commerce.smart_vyapar.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionEvent {
    private Long productId;
    private TransactionType transactionType;

    private TransactionStatus transactionStatus;

    private Integer transactionQty;

}
