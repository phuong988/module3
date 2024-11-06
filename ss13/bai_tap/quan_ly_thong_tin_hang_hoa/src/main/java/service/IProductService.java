package service;

import model.ProduceItem;

import java.util.List;

public interface IProduceItemService {
    List<ProduceItem> findAll();
    void deleteById(int id);
    void addProduceItem(ProduceItem produceItem);
    List<ProduceItem> findByName(String name);
    List<ProduceItem> findByTypeOfProduce(String type);
}
