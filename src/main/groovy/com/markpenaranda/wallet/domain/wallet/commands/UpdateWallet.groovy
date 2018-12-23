package com.markpenaranda.wallet.domain.wallet.commands

import javax.validation.constraints.NotNull

class UpdateWallet {

    UpdateWallet(String id, String label) {
        this.id = id
        this.label = label
    }

    @NotNull
    private final String id

    String getId () {
        return id
    }



    @NotNull
    private final String label

    String getLabel() {
        return label
    }
}
