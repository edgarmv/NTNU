birthdays = {
    "22 nov": ["Lars", "Mathias"],
    "10 des": "Elle",
    "30 okt": ["Veronica", "Rune"],
    "12 jan": "Silje",
    "31 okt": "Willy",
    "8 jul": ["Brage", "Øystein"],
    "1 mar": "Nina"
}

def add_birthday_to_date(date, name):
    try:
        birthdays[date].append(name)
    except AttributeError:
        birthdays[date] = [birthdays[date]]
        birthdays[date].append(name)
    except KeyError:
        birthdays.setdefault(date, name)

add_birthday_to_date("12 jan", "Sindre")
add_birthday_to_date("9 feb", "Lillian")
add_birthday_to_date("30 okt", "Gunnar")
print(birthdays)
