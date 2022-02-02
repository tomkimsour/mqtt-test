FROM python:3.8-slim-buster
EXPOSE 1883
COPY requirements.txt requirements.txt
RUN pip install --no-cache-dir -r requirements.txt
COPY . .
CMD ["python3", "publisher.py"]