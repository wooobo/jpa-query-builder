package persistence.ddl;

import domain.Person;
import org.junit.jupiter.api.Test;
import persistence.Columns;
import persistence.EntityReflectionManager;
import persistence.Table;

import static org.assertj.core.api.Assertions.assertThat;

class CreateTableBuilderTest {

    @Test
    void createDDL() {
        EntityReflectionManager entityScanner = new EntityReflectionManager(Person.class);
        Table table = entityScanner.table();
        Columns columns = entityScanner.columns();

        CreateTableBuilder actual = new CreateTableBuilder(table, columns);

        assertThat(actual.query()).isEqualTo("create table Person (id bigint generated by default as identity,nick_name varchar(255) ,old integer ,email varchar(255) not null,primary key (id));");
    }

}
