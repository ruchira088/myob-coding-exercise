# MYOB coding exercise

## Getting Stated

The input is read from `input.csv` which is in the root directory of the project.

Example

```text
Input (first name, last name, annual salary, super rate (%), payment start date):
David,Rudd,60050,9%,01 March – 31 March
Ryan,Chen,52000,10%,01 March – 14 March
John,Smith,105000,9%,20 December 2016 - 19 January 2017
```
The payment period MUST have one of the following formats

```text
dd MMMM - dd MMMM
dd MMMM yyyy - dd MMMM yyyy

```

#### Examples


```text
01 March - 14 March
01 March - 31 March
10 December 2016 - 09 January 2017
```

The payment period can either be **MONTHLY** or **FORTNIGHTLY**. This is determined by the duration of the payment period. The values of the output are dependent on the payment period. If the payment period is **FORTNIGHTLY**, then the values of the output will be for a **FORTNIGHTLY** period.

In the input example, **Ryan's** values will be for a **FORTNIGHTLY** period while **David's** and **John's** values will be for a **MONTHLY** period. 

To run the application, goto the root directory of the project and type

```sh
sbt run
```

The output is written to `output.cvs` located the in root directory of the project.

#### Example

```text
Output (name, pay period, gross income, income tax, net income, super):
David Rudd,01 March – 31 March,5004,922,4082,450
Ryan Chen,01 March – 14 March,2000,325,1675,200
John Smith,20 December 2016 - 19 January 2017,8750,2233,6517,788
```

## Testing

To execute the test suite, navigate to the root directory of the project and type

```sh
sbt test
```