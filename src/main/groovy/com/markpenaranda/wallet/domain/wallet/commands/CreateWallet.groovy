package com.markpenaranda.wallet.domain.wallet.commands


import javax.validation.constraints.NotNull
import lombok.Value

@Value
class CreateWallet {

    CreateWallet(String id, String label) {
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
