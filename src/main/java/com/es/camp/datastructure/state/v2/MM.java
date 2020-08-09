package com.es.camp.datastructure.state.v2;

public class MM {

    String name;

    /**
     * 根据状态做出决定.
     */
    MMState state = new MMHappyState();

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void sad() {
        state.sad();
    }
}
