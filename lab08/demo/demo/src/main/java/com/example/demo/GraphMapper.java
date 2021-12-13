package com.example.demo;

interface GraphMapper<TEntity>{
    ChartData mapToEntity(TEntity obj);
}