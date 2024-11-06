package service;

import model.ProduceItem;

import java.util.List;

public class ProduceItemService implements IProduceItemService {
    @Override
    public List<ProduceItem> findAll() {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void addProduceItem(ProduceItem produceItem) {

    }

    @Override
    public List<ProduceItem> findByName(String name) {
        return List.of();
    }

    @Override
    public List<ProduceItem> findByTypeOfProduce(String type) {
        return List.of();
    }
}
