package com.markpenaranda.wallet.resources

import com.markpenaranda.wallet.domain.wallet.commands.CreateWallet
import com.markpenaranda.wallet.queries.wallet.Wallet
import com.markpenaranda.wallet.queries.wallet.WalletRepository
import com.markpenaranda.wallet.resources.request.CreateWalletRequest
import lombok.RequiredArgsConstructor
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.common.IdentifierFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


import static org.springframework.http.HttpStatus.NO_CONTENT


@RestController
@RequiredArgsConstructor
class WalletResource {

    private final IdentifierFactory identifierFactory = IdentifierFactory.getInstance();

    @Autowired
    private final CommandGateway commandGateway

    @Autowired
    WalletRepository walletRepository

    @RequestMapping(value = "/wallets", method = RequestMethod.GET)
    Wallet [] wallets () {
        walletRepository.findAll()
    }


    @RequestMapping(value = "/wallets", method = RequestMethod.POST)
    @ResponseStatus(value = NO_CONTENT)
    void createWallet (@RequestBody CreateWalletRequest request) {
        commandGateway.send(new CreateWallet(identifierFactory.generateIdentifier(), request.getLabel()))

    }


}
