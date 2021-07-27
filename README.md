# REST API example application

Application providing a REST API to translate sentences based on the dictionary



# REST API

The REST API to the app is described below.

## Translate the sentence

### Request

```
POST /translate

URL parameters:
- sentenceToTranslate - required
- mode NORMAL/WITH_QUOTES - optional (NORMAL is set as a default)
```

### Response
    Content-Type: text/plain;charset=UTF-8
    Code: 200
    Alice has a cat

## Sorted list of words with their usages

### Request

```
GET /result
```
### Response
    Content-Type: application/json
    Code: 200
    {"Ala":2,"kota":1,"ma":1}
