
package com.fireforest.repository;

import com.fireforest.entity.Forest;
import lombok.Getter;
import org.springframework.stereotype.Repository;

@Getter
@Repository
public class ForestRepository {
    private Forest forest;
    public void saveForest(Forest forest) {
        this.forest = forest;
    }
}
