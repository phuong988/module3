package repository;

import model.ProduceItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import repository.BaseRepository;

public class ProduceItemRepository implements IProduceItemRepository {

    @Override
    public List<ProduceItem> findAll() {
        List<ProduceItem> produceItems = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM produce_item")) {
            while (resultSet.next()) {
                ProduceItem produceItem = new ProduceItem(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("unit"),
                        resultSet.getDouble("price"),
                        resultSet.getString("type_of_produce")
                );
                produceItems.add(produceItem);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produceItems;
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM produce_item WHERE id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProduceItem(ProduceItem produceItem) {
        String INSERT_SQL = "INSERT INTO produce_item (id,name, unit, price, type_of_produce) VALUES (?,?,?,?,?)";
        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
        preparedStatement.setString(1,produceItem.getId());
        preparedStatement.setString(2,produceItem.getProductName());
        preparedStatement.setString(3,produceItem.getUnit());
        preparedStatement.setDouble(4,produceItem.getPrice());
        preparedStatement.setString(5,produceItem.getTypeOfGoods());

        preparedStatement.executeUpdate();
        }
     catch (SQLException e) {
            throw new RuntimeException(e);
        }

        @Override
    public List<ProduceItem> findByName(String name){
        for(produceItem : findAll()){}
        }
    @Override
    public List<ProduceItem> findByTypeOfProduce(String type) {
        return List.of();
    }
}
