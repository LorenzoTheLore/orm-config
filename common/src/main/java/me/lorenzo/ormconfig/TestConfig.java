package me.lorenzo.ormconfig;

import me.lorenzo.ormconfig.annotation.OrmConfig;
import me.lorenzo.ormconfig.annotation.OrmField;

@OrmConfig
public class TestConfig {
    @OrmField(path = "Nome")
    private String nome;
    @OrmField
    private int test;

    public TestConfig(String nome, int test) {
        this.nome = nome;
        this.test = test;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
