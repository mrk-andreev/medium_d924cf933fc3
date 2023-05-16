package name.mrkandreev.benchmark;

import name.mrkandreev.code.SubstringCounter;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 10, timeUnit = SECONDS)
@Measurement(iterations = 10, time = 60, timeUnit = SECONDS)
public class SubstringCounterBenchmark {
    public SubstringCounter counter;


    @Param({"IndexOfSubstringCounterImpl", "IndexOfWithJumpSubstringCounterImpl", "RegExSubstringCounterImpl", "ReplaceBasedSubstringCounterImpl"})
    public String impl;

    @Setup
    public void prepare() throws Exception {
        counter = (SubstringCounter) getClass().getClassLoader().loadClass("name.mrkandreev.code." + impl).getDeclaredConstructor().newInstance();
    }

    @Benchmark
    public void bench(Blackhole blackhole) {
        blackhole.consume(counter.count("abxxabxab", "ab"));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(SubstringCounterBenchmark.class.getSimpleName()).forks(1).build();

        new Runner(opt).run();
    }
}
