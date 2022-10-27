package it.unibo.generics.graph.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Map<N, Set<N>> arches = new HashMap<>();

    @Override
    public void addNode(final N node) {
        this.arches.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(final N source, final N target) {
        if(isNodeExist(source, target)) {
            this.arches.get(source).add(target);
        }
        else {
            throw new IllegalArgumentException("There isn't the node " + source + " or " + target);
        }
    }

    private boolean isNodeExist(final N source, final N target) {
        return this.arches.containsKey(source) && this.arches.containsKey(target);
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(this.arches.keySet());
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return this.arches.get(node);
    }

    @Override
    public List<N> getPath(N source, N target) {
        if(isNodeExist(source, target)){
            return null;
        }
        else {
            return Collections.emptyList();
        }
    }

    
    
}
