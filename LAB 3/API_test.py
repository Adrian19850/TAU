import requests
import json

p={"page":2}
resp = requests.get("https://reqres.in/api/users", params=p)
json_response=resp.json()
assert json_response['total']==12
assert json_response['total_pages']==2, "Total pages count is not matching"
assert (json_response["data"][2]["last_name"])!=None
#print(json_response["data"])


# sprawdzanie niepoprawnego zapytania
resp_not=requests.get("https://reqres.in/api/users/23")
json_response=resp_not.json()
#print(resp_not.json())
assert resp_not.status_code == 404
# -----------------------------------

payload={
"name": "Adrian",
    "job": "Nawigator"
}

resp_create=requests.post("https://reqres.in/api/users", data=payload)
assert resp_create.status_code == 201
assert resp_create.json()['job']=='Nawigator', ['name']=="Adrian"



payload_put={
    "name": "Name PUT",
    "job": "Job PUT"
}

resp_put=requests.put("https://reqres.in/api/users/2", data=payload_put)
#print(resp_put.json())
assert resp_put.json()['job']=='Job PUT'

payload_regist={
        "id": 4,
        "token": "QpwL5tke4Pnpja7X4"
}

resp_regist=requests.post("https://reqres.in/api/register")
#print(resp_regist.status_code)


resp_del=requests.delete("https://reqres.in/api/users/2")
#print(resp_del.status_code)
assert resp_del.status_code==204, "user deletion failure"


