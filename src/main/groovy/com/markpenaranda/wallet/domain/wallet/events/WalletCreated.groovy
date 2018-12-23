package com.markpenaranda.wallet.domain.wallet.events

import lombok.Value

@Value
class WalletCreated {

    String id

    String label
}
