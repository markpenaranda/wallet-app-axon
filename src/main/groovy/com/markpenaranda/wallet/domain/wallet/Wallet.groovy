package com.markpenaranda.wallet.domain.wallet

import com.markpenaranda.wallet.domain.wallet.commands.CreateWallet
import com.markpenaranda.wallet.domain.wallet.events.WalletCreated
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.spring.stereotype.Aggregate
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply

@Aggregate
class Wallet {

    @AggregateIdentifier
    private String id


    @CommandHandler
    Wallet(CreateWallet command) {
        apply(new WalletCreated(command.getId(), command.getLabel()))
    }

    Wallet() {

    }

    @EventSourcingHandler
    void on(WalletCreated event) {
        this.id = event.getId()
    }



}
