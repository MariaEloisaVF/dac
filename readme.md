# Instruções de Build e Deploy (DAC)

## 1. Build dos JARs

Execute o comando em cada módulo (`manager` e `proxy`):

```bash
mvn clean package -DskipTests
```

---

## 2. Build das imagens Docker localmente

No diretório `/dac`, execute:

```bash
docker build -t charge-manager:latest ./charge-manager
docker build -t charge-proxy:latest ./charge-proxy
```

---

## 3. Inicializar o Swarm

```bash
docker swarm init
```

---

## 4. Criar a rede `dac-net`

```bash
docker network create --driver overlay dac-net
```

---

## 5. Deploy utilizando Docker Stack

```bash
docker stack deploy -c docker-stack.yml dac
```
