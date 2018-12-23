package com.markpenaranda.wallet.resources.request

import lombok.Value

import javax.validation.constraints.NotNull

@Value
class CreateWalletRequest {

    private String label

    String getLabel () {
        label
    }
}
