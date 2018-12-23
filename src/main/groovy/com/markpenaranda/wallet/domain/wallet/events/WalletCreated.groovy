package com.markpenaranda.wallet.domain.wallet.events

import lombok.Value

@Value
class WalletCreated {

    WalletCreated(String id, String label) {
        this.id = id
        this.label = label
    }

    private final String id

    String getId() {
        return id
    }

    private final String label

    String getLabel() {
        return label
    }
}
