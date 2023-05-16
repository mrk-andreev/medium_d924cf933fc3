```
# JMH version: 1.36
# VM version: JDK 17.0.7, OpenJDK 64-Bit Server VM, 17.0.7+7-LTS
# VM options: -javaagent:/opt/jetbrains/idea-IU-213.6777.52/lib/idea_rt.jar=46463:/opt/jetbrains/idea-IU-213.6777.52/bin -Dfile.encoding=UTF-8
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time

(impl)                                Mode  Cnt      Score     Error   Units
IndexOfWithJumpSubstringCounterImpl  thrpt   10  86171.752 ± 225.064  ops/ms
IndexOfSubstringCounterImpl          thrpt   10  77560.418 ± 154.745  ops/ms
ReplaceBasedSubstringCounterImpl     thrpt   10  29758.761 ±  35.899  ops/ms
RegExSubstringCounterImpl            thrpt   10   5121.197 ±  10.030  ops/ms
```
