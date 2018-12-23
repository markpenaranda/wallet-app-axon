package com.markpenaranda.wallet.queries.wallet

import org.springframework.data.mongodb.repository.MongoRepository

interface WalletRepository extends MongoRepository<Wallet, String> {
}
