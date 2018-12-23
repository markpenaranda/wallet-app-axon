package com.markpenaranda.wallet.domain.wallet.commands


import javax.validation.constraints.NotNull

class CreateWallet {

    @NotNull
    String id

    @NotNull
    String label


}
