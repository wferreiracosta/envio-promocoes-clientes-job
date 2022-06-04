package br.com.wferreiracosta.enviopromocoesclientes.configs;

import br.com.wferreiracosta.enviopromocoesclientes.jobs.EnvioPromocoesClientesScheduleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail quartzJobDetail(){
        return JobBuilder
                .newJob(EnvioPromocoesClientesScheduleJob.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger jobTrigger(){
        final var schedulerBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(60)
                .withRepeatCount(2);

        return TriggerBuilder.newTrigger()
                .forJob(quartzJobDetail())
                .withSchedule(schedulerBuilder)
                .build();
    }

}
