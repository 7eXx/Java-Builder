/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashmap_testing.datastructure;

/**
 *
 * @author texx
 */
public class VariableAddressBuilder {
    
    private static final int WILDCARD_VALUE = -1;
    
    private int plcAddress = WILDCARD_VALUE;
    private int tableIndex = WILDCARD_VALUE;
    private int variableIndex = WILDCARD_VALUE;

    public VariableAddressBuilder setPlcAddress(int plcAddress) {
        this.plcAddress = plcAddress;
        
        return this;
    }

    public VariableAddressBuilder setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
        
        return this;
    }

    public VariableAddressBuilder setVariableIndex(int variableIndex) {
        this.variableIndex = variableIndex;
        
        return this;
    }
    
    public VariableAddress build() {
        if (isAnyPlcAddress()) {
            return new VariableAddressWildcard();
        }
        
        if (isAnyVariableAddress()) {
            return new VariableAddressPlcWildcard(plcAddress);
        }
        
        if (isVariableAddressDefined()) {
            return new SimpleVariableAddress(plcAddress, tableIndex, variableIndex);
        }
        
        throw new IllegalArgumentException("plcAddress, tableIndex or variableAddress combination is not valid");
    }
    
    private boolean isAnyPlcAddress() {
        return plcAddress == WILDCARD_VALUE
                && tableIndex == WILDCARD_VALUE
                && variableIndex == WILDCARD_VALUE;
    }
    
    private boolean isAnyVariableAddress() {
        return plcAddress != WILDCARD_VALUE
                && tableIndex == WILDCARD_VALUE
                && variableIndex == WILDCARD_VALUE;
    }
    
    private boolean isVariableAddressDefined() {
        return plcAddress != WILDCARD_VALUE
                && tableIndex != WILDCARD_VALUE
                && variableIndex != WILDCARD_VALUE;
    }
}
