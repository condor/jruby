/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jruby.compiler.ir.instructions.calladapter;

import org.jruby.compiler.ir.operands.Operand;
import org.jruby.interpreter.InterpreterContext;
import org.jruby.runtime.CallSite;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 *
 * @author enebo
 */
public class OneArgNoBlockOperandCallAdapter extends CallAdapter {
    private final Operand arg1;
    
    public OneArgNoBlockOperandCallAdapter(CallSite callSite, Operand[] args) {
        super(callSite);
        
        assert args.length == 1;
                
        this.arg1 = args[0];
    }

    @Override
    public Object call(InterpreterContext interp, ThreadContext context, IRubyObject self, IRubyObject receiver) {
        IRubyObject value1 = (IRubyObject) arg1.retrieve(interp, context, self);
        return callSite.call(context, self, receiver, value1);
    }
}