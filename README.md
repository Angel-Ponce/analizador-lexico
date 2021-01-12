# Lexic-Analizer
Introduction to formal programming languages

![image](https://user-images.githubusercontent.com/60164099/104361574-3e4f8500-54d8-11eb-9854-8155a2e2fa97.png)

## What is it?
It is a formal study of how text analyzers are built to carry out programming languages, syntax rules, semantics, etc

## Features
- Upload files with extension (.txt) for analize some programing languages
- Modify root files to customize tokens and more...
- Lexical analysis report
- Minimum report of token appearance
- See your tokens
- Add new tokens
- Add new data type
- add new modifier acces
- Saver reports
- Default laguage: Java or similar like C#

## How to use
First install project in your system
```sh
$ git clone https://github.com/Angel-Ponce/analizador-lexico
```

To configure your own language go to the folder ``` .. \ analyzer \ src \ Files ``` and modify the files that the folder contains
| File | Description |
| ------ | ------ |
| `accessmodifiers.txt` | It refers to the access modifiers that your fields may have |
| `datatypes.txt` | The types of data you want to be recognized |
| `Origin.txt` | Test your lexical analyzer with some example of your programming language |
| `Tokens.txt` | Words reserved by your programming language |

Note: In the file `Tokens.txt` must be the combination of the files `accessmodifiers.txt` and  `datatypes.txt`

# Authors
[Angel Ponce](https://github.com/Angel-Ponce)

[Carlos Dubón](https://github.com/carlos-dubon)
