package com.markpenaranda.wallet.queries.wallet

import com.markpenaranda.wallet.domain.wallet.events.WalletCreated
import org.axonframework.eventhandling.EventHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

@Component
class WalletUpdaterEventHandler {

    @Autowired
    WalletRepository repository

    @EventHandler
    void on(WalletCreated event) {
        Wallet wallet = new Wallet(id: event.getId(), label: event.getLabel())
        repository.save(wallet)
    }


}
