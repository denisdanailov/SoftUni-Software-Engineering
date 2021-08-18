package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {
        private Collection<Table> tables;

        public TableRepositoryImpl() {
           this.tables = new ArrayList<>();
        }

    @Override
    public Collection<Table> getAll() {
        return this.tables;
    }

    @Override
    public void add(Table table) {
        tables.add(table);
    }

    @Override
    public Table getByNumber(int number) {

        return tables.stream().filter(table -> {
            return table.getTableNumber() == number;
        }).findFirst().orElse(null);

    }
}
