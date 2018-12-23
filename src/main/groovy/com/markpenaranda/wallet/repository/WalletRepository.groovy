package com.markpenaranda.wallet.repository

import com.markpenaranda.wallet.queries.wallet.Wallet
import org.springframework.data.mongodb.repository.MongoRepository

interface WalletRepository extends MongoRepository<Wallet, String>{

}
