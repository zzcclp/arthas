package com.taobao.arthas.core.distribution.impl;

import com.taobao.arthas.core.command.result.ExecResult;
import com.taobao.arthas.core.command.view.ResultView;
import com.taobao.arthas.core.command.view.ResultViewResolver;
import com.taobao.arthas.core.distribution.ResultDistributor;
import com.taobao.arthas.core.shell.command.CommandProcess;

/**
 * Term/Tty Result Distributor
 *
 * @author gongdewei 2020-03-26
 */
public class TermResultDistributorImpl implements ResultDistributor {

    private final CommandProcess commandProcess;
    private final ResultViewResolver resultViewResolver;

    public TermResultDistributorImpl(CommandProcess commandProcess) {
        this.commandProcess = commandProcess;
        this.resultViewResolver = ResultViewResolver.getInstance();
    }

    @Override
    public void appendResult(ExecResult result) {
        ResultView resultView = resultViewResolver.getResultView(result.getType());
        resultView.draw(commandProcess, result);
    }

}