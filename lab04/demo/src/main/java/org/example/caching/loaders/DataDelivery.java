package org.example.caching.loaders;
import org.example.model.Dictionary;
import java.util.List;

public interface DataDelivery {
    List<Dictionary> dataLoad();
}
