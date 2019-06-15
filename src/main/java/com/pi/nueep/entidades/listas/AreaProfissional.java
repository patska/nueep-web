package com.pi.nueep.entidades.listas;

/**
 * AreaProfissional
 */
public enum AreaProfissional {


    AREA_1("Administração"),

    AREA_2("Agricultura, Pecuária, Veterinária"),

    AREA_3("Alimentação / Gastronomia"),

    AREA_4("Arquitetura, Decoração, Design"),

    AREA_5("Artes"),

    AREA_6("Auditoria"),

    AREA_7("Ciências, Pesquisa"),

    AREA_8("Comercial, Vendas"),

    AREA_9("Comércio Exterior, Importação, Exportação"),

    AREA_10("Compras"),

    AREA_11("Comunicação, TV, Cinema"),

    AREA_12("Construção, Manutenção"),

    AREA_13("Contábil, Finanças, Economia"),

    AREA_14("Cultura, Lazer, Entretenimento"),

    AREA_15("Educação, Ensino, Idiomas"),

    AREA_16("Engenharia"),

    AREA_17("Estética"),

    AREA_18("Hotelaria, Turismo"),

    AREA_19("Industrial, Produção, Fábrica"),

    AREA_20("Informática, TI, Telecomunicações"),

    AREA_21("Jurídica"),

    AREA_22("Logística"),

    AREA_23("Marketing"),

    AREA_24("Meio Ambiente, Ecologia"),

    AREA_25("Moda"),

    AREA_26("Qualidade"),

    AREA_27("Química, Petroquímica"),

    AREA_28("Recursos Humanos"),

    AREA_29("Saúde"),

    AREA_30("Segurança"),

    AREA_31("Serviços Gerais"),

    AREA_32("Serviço Social e Comunitário"),

    AREA_33("Telemarketing"),

    AREA_34("Transportes");

    private final String name;

    AreaProfissional(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}