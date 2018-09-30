package com.github.julianps.modelmapper.playground;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ModelMapperBenchmarkTest {

    @State(Scope.Thread)
    public static class BenchmarkState {
        List<User> randomUsers;

        @Setup(Level.Trial)
        public void initialize() {
            randomUsers = UserFactory.generateRandomUsers();
        }
    }

    @Benchmark
    public void ourStyle(BenchmarkState state, Blackhole bh) {
        for (int i = 0; i < state.randomUsers.size(); i++) {
            bh.consume(UserConverter.toUserDTO(state.randomUsers.get(i)));
        }
    }

    @Benchmark
    public void modelmapperStyle(BenchmarkState state, Blackhole bh) {
        for (int i = 0; i < state.randomUsers.size(); i++) {
            bh.consume(UserConverter.toUserDTOwithModelMapper(state.randomUsers.get(i)));
        }
    }

    @Test
    public void debugHelper(){
        UserFactory.generateRandomUsers();
    }

    @Test
    public void initBenchmarkTest() throws RunnerException {
        Options options = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(5)
                .measurementTime(TimeValue.seconds(2))
                .measurementIterations(5)
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();
        new Runner(options).run();
    }
}
