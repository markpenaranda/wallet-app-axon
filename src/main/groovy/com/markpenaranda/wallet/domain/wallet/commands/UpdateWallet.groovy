package com.markpenaranda.wallet.domain.wallet.commands

import javax.validation.constraints.NotNull

class UpdateWallet {


    @NotNull
    String id

    @NotNull
    String label

}
