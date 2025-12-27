resultat de perf en utilisant thread classique et virtuel thread 


Platform threads (Tomcat classique)

✅ très bon CPU-bound

❌ mauvais I/O-bound (bloque des threads OS)

Virtual threads (Tomcat + Spring)

✅ excellent I/O-bound (libère les threads OS)

❌ pas magique sur CPU-bound (peut empirer)

** docker run --rm williamyeh/wrk `
>>   -t4 -c100 -d30s --latency `
>>   http://host.docker.internal:8080/api/v1/process?scenario=ping
Running 30s test @ http://host.docker.internal:8080/api/v1/process?scenario=ping
  4 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     9.96ms    4.14ms  51.96ms   71.81%
    Req/Sec     2.34k   259.34     3.09k    68.25%
  Latency Distribution
     50%    9.10ms
     75%   12.30ms
     90%   15.51ms
     99%   22.83ms
  279699 requests in 30.06s, 30.73MB read
Requests/sec:   9304.63
Transfer/sec:      1.02MB
PS C:\Users\ouame> docker run --rm williamyeh/wrk `
>>   -t4 -c200 -d30s --latency `
>>   http://host.docker.internal:8080/api/v1/process?scenario=ping
Running 30s test @ http://host.docker.internal:8080/api/v1/process?scenario=ping
  4 threads and 200 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    21.50ms   11.86ms 133.62ms   73.62%
    Req/Sec     2.36k   274.66     3.15k    68.33%
  Latency Distribution
     50%   18.69ms
     75%   26.87ms
     90%   37.64ms
     99%   59.97ms
  281566 requests in 30.08s, 30.93MB read
Requests/sec:   9360.19
Transfer/sec:      1.03MB
PS C:\Users\ouame> docker run --rm williamyeh/wrk `
>>   -t4 -c200 -d30s --latency `
>>   http://host.docker.internal:8080/api/v1/process?scenario=ping
Running 30s test @ http://host.docker.internal:8080/api/v1/process?scenario=ping
  4 threads and 200 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    35.29ms   30.89ms 417.96ms   93.64%
    Req/Sec     1.57k   342.60     2.35k    76.92%
  Latency Distribution
     50%   29.39ms
     75%   43.51ms
     90%   58.55ms
     99%  163.82ms
  185090 requests in 30.04s, 20.33MB read
Requests/sec:   6161.52
Transfer/sec:    693.05KB
PS C:\Users\ouame>**
