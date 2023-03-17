/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashmap_testing.datastructure;

import java.util.Objects;

/**
 *
 * @author texx
 */
public abstract class AbstractVariableAddress implements VariableAddress {
    
    protected static int WILDCARD_VALUE = -1;
    
    private final int plcAddress;
    
    private final int tableIndex;
    
    private final int variableIndex;
    
    protected AbstractVariableAddress(int plcAddress, int tableIndex, int variableIndex) {
        this.plcAddress = plcAddress;
        this.tableIndex = tableIndex;
        this.variableIndex = variableIndex;
    }

    @Override
    public int getPlcAddress() {
        return plcAddress;
    }

    @Override
    public int getTableIndex() {
        return tableIndex;
    }

    @Override
    public int getVariableIndex() {
        return variableIndex;
    }

    @Override
    public int hashCode() {
        return plcAddress ^ tableIndex ^ variableIndex;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractVariableAddress)) {
            return false;
        }
        
        AbstractVariableAddress that = (AbstractVariableAddress) obj;
        
        return this.plcAddress == that.plcAddress
                && this.tableIndex == that.tableIndex
                && this.variableIndex == that.variableIndex;
    }
    
}
