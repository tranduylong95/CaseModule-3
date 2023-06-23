package com.example.service;

import com.example.database.ConnectionDatabase;
import com.example.model.Transaction;
import com.example.repository.ITransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionService implements ITransaction {
    @Override
    public void insertChapter(Transaction transaction) throws SQLException {
        Connection connection = ConnectionDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("INSERT INTO `commicdb`.`transaction` (`id_transactoin`, `id_user`, `amount`) VALUES (?, ?, ?);");
        preparedStatement.setInt(1, transaction.getId_transaction());
        preparedStatement.setInt(2, transaction.getId_user());
        preparedStatement.setInt(3, transaction.getAmount());
        preparedStatement.executeUpdate();
        connection.close();
    }
}
