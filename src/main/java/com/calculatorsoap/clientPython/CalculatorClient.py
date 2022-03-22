from suds.client import Client
import sys 

url: str = "http://localhost:8080/ws/calculator.wsdl"
client = Client(url)

def calculatetorClient(num0, num1, operation):
    expression = client.factory.create('ns0:expression')
    expression.num0 = num0 
    expression.num1 = num1
    expression.operation = operation

    result = client.service.calculator(expression)
    return result 

if __name__ == "__main__":
    if (len(sys.argv) == 4):
        print("num0: ", sys.argv[1])
        print("num1: ", sys.argv[2])
        print("operation: ", sys.argv[3])
        print(calculatetorClient( int(sys.argv[1]), int(sys.argv[2]), str(sys.argv[3]) ))