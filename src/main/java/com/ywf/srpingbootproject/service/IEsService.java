package com.ywf.srpingbootproject.service;

public interface IEsService {
    void index(String index, String type, String id);

    Object get(String index, String type, String id);

    Object exists(String index, String type, String id);

    Object update(String index, String type, String id);

    Object delete(String index, String type, String id);

    Object searchByDFSQueryThenFetch(String index, String key);

    Object searchByQueryThenFetch(String index, String key);

    Object query(String index, String key, int pageNum, int pageSize);
}
