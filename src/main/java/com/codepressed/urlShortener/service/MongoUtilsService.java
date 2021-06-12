package com.codepressed.urlShortener.service;

public interface MongoUtilsService {

    /**
     * Mongo autoincremental
     * @param sequenceId
     * @return sequenceId next value
     */
    public Long getNextValue(String sequenceId);

}
