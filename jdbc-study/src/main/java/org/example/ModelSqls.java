package org.example;

public class ModelSqls {
    public static final String SELECT_ALL = "SELECT modelname FROM model;";
    public static final String SELECT_BY_MODEL_NAME = "SELECT modelname FROM model WHERE modelname = :modelname";
    public static final String DELETE_BY_MODEL_NAME = "DELETE FROM model WHERE modelname = :modelname";
}
